//package com.mock.flight.services;
//
//import com.mock.flight.model.User;
//import com.mock.flight.repository.UserRepository;
//import com.mock.flight.security.UserPrincipal;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUsername(username);
//        if(user == null){
//            throw new UsernameNotFoundException("Can not find name null");
//        }
//     return new UserPrincipal(user);
//    }
//
//
//}
