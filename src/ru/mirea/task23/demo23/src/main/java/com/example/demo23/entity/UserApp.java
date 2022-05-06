package com.example.demo23.entity;

import com.example.demo23.tables.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Нужен чтобы юзать спринг.
 * Для того, чтобы в дальнейшим использовать класс Userв Spring Security,
 * он должен реализовывать интерфейс UserDetails.
 * Для этого нужно переопределить все его методы.
 * Но в нашем примере мы будем использовать только метод getAuthorities(), он возвращает список ролей пользователя.
 * Поэтому для остальных методов измените возвращаемое значение на true.* */
public class UserApp  implements UserDetails {
    private final Collection<? extends GrantedAuthority> authorityArrayList = new ArrayList<>();
    private final User user;

    public UserApp(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityArrayList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
