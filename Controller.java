import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {
  protected Scanner input;
  protected PedidoDao pedidoDao;
  protected PratoDao pratoDao;

  Controller(){
    input = new Scanner(System.in);
    pratoDao = PratoDao.getInstance();
    pedidoDao = PedidoDao.getInstance();
  }


  public int readInteger(){
    int value = 0;
    while(true){
      try{
        String s;
        s = input.nextLine();
        value = Integer.parseInt(s);
        break;
      }
      catch(NoSuchElementException nsee){
        System.out.println("Erro na leitura da linha");
      }
      catch(NumberFormatException nfe){
        System.out.println("Numero invalido!");
      }
      catch(Exception e){
        System.out.println("Um erro interno ocorreu");
      }
    }
    return value;
  }

  public int readIntRange(int start, int end){
    int value;
    while(true){
      value = readInteger();
      if(start <= value && value <= end){
        return value;
      }
      System.out.println("Valor invalido!");
    }
  }

  public int readIntRange(int start, int end, int exception){
    int value;
    while(true){
      value = readInteger();
      if(start <= value && value <= end && value != exception){
        return value;
      }
      System.out.println("Valor invalido!");
    }
  }

  public int readIntRange(int start){
    int value;
    while(true){
      value = readInteger();
      if(start <= value){
        return value;
      }
      System.out.println("Valor invalido!");
    }
  }

  public double readDouble(){
    double value = 0;
    while(true){
      try{
        String s;
        s = input.nextLine();
        value = Double.parseDouble(s);
        break;
      }
      catch(NoSuchElementException nsee){
        System.out.println("Erro na leitura da linha");
      }
      catch(NumberFormatException nfe){
        System.out.println("Numero invalido!");
      }
      catch(Exception e){
        System.out.println("Um erro interno ocorreu");
      }
    }
    return value;
  }

public double readDoubleRange(double start){
  double value;
  while(true){
    value = readDouble();
    if (value >= start) {
      return value;
    }
    System.out.println("Valor invalido!");
  }
}

}
