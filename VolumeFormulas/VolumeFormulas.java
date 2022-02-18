class VolumeFormulas {
   public int counter;
   private double height;
   private double radius;
      
   // Constructors
   
   VolumeFormulas() {
      counter = 0;
      height = 1;
      radius = 1;
   }
   
   VolumeFormulas(double inputRadius) {
      radius = inputRadius;
   }
   
   VolumeFormulas(double inputRadius, double inputHeight) {
      radius = inputRadius;
      height = inputHeight;
   }
   
   // Volume Methods that work depending on the constructor
   
   
   // Volume of a cylinder 
   
   double cylinderVolume () {
      double cylVol;
      
      cylVol = Math.PI * (radius * radius) * height;
      
      counter++;
      
      return cylVol;
   
   }
   
   double cylinderVolume (double radInput, double heiInput) {
   
      double cylVol;
      radius = radInput;
      height = heiInput;
      
      cylVol = Math.PI * (radius * radius) * height;
      
      counter++;
      
      return cylVol;
   }
   
   // Functions for determining volume of a sphere
   
   double sphereVolume () {
   
      double sphVol;
   
      sphVol = Math.PI * (radius * radius * radius) * 1.33333333333333;
      
      counter++;
      
      return sphVol;
   }
   
   double sphereVolume (double radInput) {
   
      double sphVol;
      radius = radInput;
   
      sphVol = Math.PI * (radius * radius * radius) * 1.33333333333333;
      
      counter++;
      
      return sphVol;
   }
   
   // Functions for determining volume of a Cone 
   
   double coneVolume (double radInput, double heiInput) {
      double conVol;
      radius = radInput;
      height = heiInput;
      
      counter++;
      
      conVol = Math.PI * (radius * radius) * (height / 3);
      
      return conVol;
   }
   
   double coneVolume () {
      double conVol;
      
      counter++;
      
      conVol = Math.PI * (radius * radius) * (height / 3);
      
      return conVol;
   }
   
   // Method to return counter value
   
   int counterValue () {
      return counter;
   }
}
