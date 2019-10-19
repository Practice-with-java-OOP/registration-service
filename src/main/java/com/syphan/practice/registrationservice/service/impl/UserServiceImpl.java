package com.syphan.practice.registrationservice.service.impl;

import com.syphan.practice.commonservice.exception.BIZException;
import com.syphan.practice.commonservice.model.enumclass.ErrType;
import com.syphan.practice.commonservice.service.impl.BaseServiceImpl;
import com.syphan.practice.commonservice.util.GenerateAvatarUtils;
import com.syphan.practice.dto.registration.UserCreateDto;
import com.syphan.practice.houseservice.service.BoardingHouseService;
import com.syphan.practice.registrationservice.model.Role;
import com.syphan.practice.registrationservice.model.User;
import com.syphan.practice.registrationservice.repository.RoleRepository;
import com.syphan.practice.registrationservice.repository.UserRepository;
import com.syphan.practice.registrationservice.service.UserService;
import com.syphan.practice.registrationservice.util.Utils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@org.apache.dubbo.config.annotation.Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Reference
    private BoardingHouseService houseService;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public String sendUserSignUpMailCaptcha(String email) throws BIZException {
        return null;
    }

    @Override
    public User signUp(UserCreateDto data) throws BIZException {
        if (repository.findByUsername(data.getUsername()) != null) {
            throw BIZException.buildBIZException(ErrType.CONFLICT,
                    "Signup.Username.Occupied", "The username to be registered is already occupied.");
        }

        if (data.getEmail() != null && repository.findByEmail(data.getUsername()) != null) {
            throw BIZException.buildBIZException(ErrType.CONFLICT,
                    "Signup.Email.Occupied", "The email address to be registered is already occupied.");
        }

        if (data.getPhoneNum() != null && repository.findByPhoneNum(data.getPhoneNum()) != null) {
            throw BIZException.buildBIZException(ErrType.CONFLICT,
                    "Signup.PhoneNumber.Occupied", "The phoneNumber to be registered is already occupied.");
        }

        User user = new User();
        user.setUsername(data.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(data.getPassword()));
        user.setFullName(data.getFullName());
        user.setAvatar(data.getAvatar() != null ? data.getAvatar() : GenerateAvatarUtils.generate(data.getEmail()));
        user.setEmail(data.getEmail());
        user.setPhoneNum(data.getPhoneNum());

        Set<Role> roles = new HashSet<>();
        if (!data.getRoleIds().isEmpty()) {
            List<Role> roleList = roleRepository.findAllById(data.getRoleIds());
            if (roleList.size() != new HashSet<>(data.getRoleIds()).size())
                throw BIZException.buildBIZException(ErrType.NOT_FOUND,
                        "role.do.not.existed", String.format("%s%s%s", "Role with id in list Id[ ", data.getRoleIds(), "] do not existed"));
            roles.addAll(roleList);
        } else {
            roles.add(getDefaultUserRole());
        }
        user.setRoles(roles);
        return repository.save(user);
    }

    @Override
    public User findByUsername(String username) throws BIZException {
        return repository.findByUsername(username);
    }

    private Role getDefaultUserRole() {
        Role role = roleRepository.findByCode(Utils.DEFAULT_USER_ROLE);
        if (role != null) {
            return role;
        } else {
            role = new Role();
            role.setName("User");
            role.setCode(Utils.DEFAULT_USER_ROLE);
            return roleRepository.save(role);
        }
    }
}
