public class Testes {
  public static void testPratoDao(){
	Prato lasanha = new Prato("Lasanha de Frango", 25.00, "Lasanha gostosa");
	Prato lasanha2 = new Prato("Lasanha de Carne Friboi", 34.00, "Lasanha tão gostosa quanto a outra");
	PratoDao pd = PratoDao.getInstance();
	// System.out.println(pd.getAll().toString());

	pd.save(lasanha);
	pd.save(lasanha2);
	// System.out.println(pd.getAll().toString());

	lasanha.setNome("Lasanha de Chicken");
	pd.update(lasanha);
	// System.out.println(pd.getAll().toString());

	pd.delete(lasanha2);
	// System.out.println(pd.getAll().toString());


	System.out.println("---------------");
	// System.out.println(pd.get(lasanha2.getId()));
	// System.out.println(pd.get(lasanha.getId()));

	Pedido pedido1 = new Pedido();
	pedido1.addPrato(lasanha);
	pedido1.addPrato(lasanha2);
	System.out.println(pedido1.getPratos().get(0));
	System.out.println(pedido1.getPratos().get(1));
	System.out.println("---------------");

	PedidoDao pedidoDao = PedidoDao.getInstance();
	pedidoDao.



  }
}
