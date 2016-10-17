package com.pesahlavan.weblibrary.interfaces;


import com.pesahlavan.weblibrary.objects.User;

public interface SecureLibrary {

    boolean login(User user);

    void logout(User user);

}
