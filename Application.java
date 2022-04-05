import java.util.Locale;

class Application {
  	public static void main(String[] args) {
			Locale.setDefault(Locale.US);
			PratoDao pd = PratoDao.getInstance();
			// Viewer.menu();
			System.out.println();
			// Viewer.verCardapio(pd.getAll());
  	}
}