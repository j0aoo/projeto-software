package Modelo;

public class Admin {
    private int id;
    private String login;
    private String senha;
    private String senhaExtra; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaExtra() {
        return senhaExtra;
    }

    public void setSenhaExtra(String senhaExtra) {
        this.senhaExtra = senhaExtra;
    }
    
}
