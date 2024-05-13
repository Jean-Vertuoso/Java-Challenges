package com.oakbank.model.services;

import com.oakbank.model.exceptions.IncorrectEmployeeAccessData;

public class AuthService {
    
    private String managerUser;
    private String employeeUser;
    private String finalUser;
    private String password;
    private boolean isAuth;
    
    public AuthService() {
        this.managerUser = "gestao@teste.com.br";
        this.employeeUser = "funcionario@teste.com.br";
        this.finalUser = "cliente@teste.com.br";
        this.password = "Teste123@";
        this.isAuth = false;
    }
    
    public boolean validateManagerUser(String user, String password) throws IncorrectEmployeeAccessData{
        if(!user.equalsIgnoreCase(this.managerUser) && !password.equals(this.password)){
            isAuth = false;
        } else {
            isAuth = true;
            System.out.println("\nUsuário Gestão validado.\n"
                + "Acessando sistema...\n");
        }
        return isAuth;
    }
    
    public boolean validateEmployeeUser(String user, String password) throws IncorrectEmployeeAccessData{
        if(!user.equalsIgnoreCase(this.employeeUser) && !password.equals(this.password)){
            isAuth = false;
        } else {
            isAuth = true;
            System.out.println("Usuário Funcionário validado.");
        }
        return isAuth;
    }
    
    public boolean validatefinalUser(String user, String password) throws IncorrectEmployeeAccessData{
        if(!user.equalsIgnoreCase(this.finalUser) && !password.equals(this.password)){
            isAuth = false;
        } else {
            isAuth = true;
            System.out.println("Usuário validado.");
        }
        return isAuth;
    }
    
}
