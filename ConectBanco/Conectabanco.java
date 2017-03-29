package ConectBanco;

import Interface.Entrar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static sun.security.jgss.GSSUtil.login;

public class Conectabanco {

    public Statement stm;
    public ResultSet rs;
    private final String driver = "org.gjt.mm.mysql";
    private final String caminho = "jdbc:mysql://localhost:3306/openkant";
    private final String usuario = "root";
    private final String senha = "";
    public Connection conn;
    private String a;
    private String b;

    public void conexao() {
        System.setProperty("jdbc:Drivers", driver);
        try {
            conn = DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conectabanco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro na conexão");
        }
    }

    public void desconectar() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conectabanco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro na desconexão");
        }
    }

    public void validar() throws SQLException {
        Entrar ent = new Entrar();
        ent.validarEmail();
        ent.validarSenha();
        try{
        String Pesquisa = ("SELECT * FROM login where Email ="+ a + " and Senha ="+ b);
        rs = stm.executeQuery(Pesquisa);
        JOptionPane.showMessageDialog(null,"Usuario Valido");
        
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Usuario Invalido");
        }
            
    }    
        }
    

