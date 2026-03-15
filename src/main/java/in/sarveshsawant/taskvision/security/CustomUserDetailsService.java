package in.sarveshsawant.taskvision.security;

import java.util.Collections;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.sarveshsawant.taskvision.entity.User;
import in.sarveshsawant.taskvision.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

        private final UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findByUsernameOrEmail(username, username)
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "User not exists by Username or Email"));

                Set<GrantedAuthority> authorities = Collections.singleton(
                                new SimpleGrantedAuthority(user.getRole().getRole()));

                CustomUserDetails customUserDetails = CustomUserDetails.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .password(user.getPassword())
                                .roles(authorities)
                                .build();

                return customUserDetails;
        }

}
