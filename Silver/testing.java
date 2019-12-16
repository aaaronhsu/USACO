class testing {
  public static void main(String[] args) {
    System.out.println(sure(10) + );
  }

  static String sure(int counter) {
    if(counter == 0) {
      return "are u sure";
    }
    else {
      return sure(counter--) + " that you're sure";
    }
  }
}
