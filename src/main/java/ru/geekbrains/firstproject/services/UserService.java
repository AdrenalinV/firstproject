package ru.geekbrains.firstproject.services;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.geekbrains.firstproject.model.entities.Role;
import ru.geekbrains.firstproject.model.entities.User;
import ru.geekbrains.firstproject.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(s).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", s)));
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority>mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public User findUserById(Long id) throws UsernameNotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException(String.format("User id='%d' not found", id)));
        return user;
    }

    public Optional<User> findUserByUsername(String s){
        return userRepository.findByUserName(s);
    }

    public void updateUser(User user){
        if(user!=null){
            userRepository.save(user);
        }
    }
}
