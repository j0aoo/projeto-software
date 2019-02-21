package Modelo;

public class Admin {
    private int id;
    private String login;
    private String senha;
    private String senhaExtra; 
    private int tipo_user;

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

    public int getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(int tipo_user) {
        this.tipo_user = tipo_user;
    }
    
}
