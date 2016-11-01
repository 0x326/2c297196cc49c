public class problem1 {
  public static void main(String[] args){
    int sum = 0;
    
    for(int currentNum=0;currentNum<1000;currentNum++){
    
      if(currentNum % 3 == 0 || currentNum % 5 == 0) {
        sum += currentNum;
      
      
      }
    }
    System.out.println(sum);
  }
}