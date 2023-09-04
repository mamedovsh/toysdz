

 class Toy {
      private int id;
      private String name;
      private int quantity;
      private double weight;

      public Toy(int id,String name,int quantity,double weight) {
          this.id =id;
          this.name = name;
          this.quantity = quantity;
          this.weight = weight;

      }

     public void setWeight(double weight) {
         this.weight = weight;
     }

     public int getId() {
         return id;
     }
     public String getName(){
          return name;

     }

     public int getQuantity() {
         return quantity;
     }

     public double setWeight() {
         return 0;
     }

     public void setQuantity() {
     }

     public void setQuantity(int i) {
     }
 }


