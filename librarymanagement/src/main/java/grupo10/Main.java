import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Inicializa a interface gráfica da biblioteca
        SwingUtilities.invokeLater(() -> {
            LibraryGUI libraryGUI = new LibraryGUI();
            libraryGUI.setVisible(true);
        });

        // Mantenha o sistema ativo até a escolha de sair do usuário
        while (true) {
            // Verifica se a janela foi fechada para encerrar o programa
            if (!LibraryGUI.isRunning()) {
                break;
            }
            
            try {
                Thread.sleep(1000); // Aguarda um segundo antes de verificar novamente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sistema de Biblioteca encerrado.");
    }
}
