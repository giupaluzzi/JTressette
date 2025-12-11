
import view.*;
import controller.ProfileController;

public class App {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();
        View view = new View(); // Crea tutti i pannelli grafici (vuoti/senza logica)

        new ProfileController(view, navigator);


        // new GameController(view, navigator); 

        navigator.navigate(Screen.START);
        }
    }
