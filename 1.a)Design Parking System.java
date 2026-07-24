/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
class ParkingSystem {
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {//Stores the initial number of parking spaces passed by LeetCode
        this.big=big;
        this.medium=medium;
        this.small=small;// 'this'-->current object and 'big'-->current object's variable
    }
    public boolean addCar(int carType) {
        /* carType is automatically passed by LeetCode
           1 -> Big car
           2 -> Medium car
           3 -> Small car */
        if(carType==1){
            if(big>0){
                big--;
                return true;
            }
            else{
                return false;
            }
        }
        if(carType==2){//If a medium car arrives
            if(medium>0){//Check whether a Medium parking space is available
                medium--;//One Medium parking space is now occupied
                return true;
            }
            else{
                return false;//No Medium parking space is available
            }
        }
        if(carType==3){
            if(small>0){
                small--;
                return true;
            }
            else{
                return false;
            }
        }
        return false;//If the car is not of any valid type(1,2 or 3)
    }
}
 /* Practical Approach:
    Store the number of Big, Medium and Small parking spaces
    Whenever a car arrives, check its type
    If a parking space of that type is available, occupy it by decreasing its count and return true
    Otherwise, return false */
