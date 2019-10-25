package org;

public class UserServiceImpl implements UserService {
    @Override
    public void registerUser() {
        System.out.println("注册了一个用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除了一个用户");
    }
    public void updateUser(){
        System.out.println("权限校验...");
        System.out.println("更新一个用户");
        System.out.println("日志记录...");
    }
}
