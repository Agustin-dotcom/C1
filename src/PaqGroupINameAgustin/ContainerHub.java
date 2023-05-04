package PaqGroupINameAgustin;

import javax.imageio.stream.ImageInputStream;
import java.util.ArrayList;
import java.util.Random;

public class ContainerHub {
    //ArrayList <Container>[][]hub;
    private Container [][]hub;
    private boolean isFullPriority1;
    private boolean isFullPriority2;
    private boolean isFullPriority3;
    public ContainerHub(){
        hub= new Container[10][12];
        for(int i=0;i<10;++i){
            for(int k=0;k<12;k++) {
                hub[i][k]= new Container(true,"0","0","",false,
                        0,"","","");
                isFullPriority1=false;
                isFullPriority2=false;
                isFullPriority3=false;
            }
        }
    }
    @Override
    public String toString() {
        String hubPlan="";
        hubPlan+="       1";
        for (int i = 2; i < 13; i++) {
                hubPlan+=" "+i;
        }
        hubPlan+="\n";
        for(int i=0;i< 10;++i){
            if(i!=9)
                hubPlan+=" ("+(i+1)+")  ";
                else
                    hubPlan+="("+(i+1)+") ";
            for(int j=0;j< 12;++j){
                if(hub[i][j].isFree()) {
                    if (j>9)
                        hubPlan += " F ";//Free
                    else hubPlan += "F ";
                }else {
                    if (j>9)
                        hubPlan += " O ";//Occupied
                    else hubPlan += "O ";
                }
            }
            hubPlan+="\n";
        }
        hubPlan+="\nF - (Free)\tO - (Occupied)";
        return hubPlan;
    }
    /**
     *This method looks for space in a given column
     * @param column
     * @return -1 if there wasn't space and the column if there was space
     *
     */
    public int removeContainerFromAColumn(int column) {
        for(int i=0;i<10;++i) {
            if(!hub[i][column-1].isFree())//if the position of our hub is not free
            {
                hub[i][column-1].setFree(true);
                hub[i][column-1].setIdNumber("0");
                hub[i][column-1].setContentDescription("");
                hub[i][column-1].setWeight("0");
                hub[i][column-1].setCompanyThatReceivesTheContainer("");
                hub[i][column-1].setCountryOfOrigin("");
                hub[i][column-1].setPriorityLevel(0);
                hub[i][column-1].setHasBeenInspected(false);
                hub[i][column-1].setCompanyThatSendsTheContainer("");
                return column;
            }
        }
        return -1;
    }

    /**
     * Piles a container in our port
     * @param  containerToPile
     */
    public void stackAContainerAccordingToPriority(Container containerToPile) {

        switch (containerToPile.getPriorityLevel()) {
            case 1 -> {
                for (int i = 9; i >= 0; --i) {
                    if (hub[i][0].isFree()) {
                        hub[i][0]=containerToPile;
                        return;
                    }
                }
                isFullPriority1=true;
            }
            case 2 -> {
                for (int i = 9; i >= 0; --i) {
                    if (hub[i][1].isFree()) {
                        hub[i][1]=containerToPile;
                        return;
                    }
                }
                isFullPriority2=true;
            }
            case 3 -> {
                for (int j = 2; j < 12; j++) {
                    for (int i = 9; i >= 0; --i) {
                        if (hub[i][j].isFree()) {
                            hub[i][j]=containerToPile;
                            return;
                        }
                    }
                }
                isFullPriority3=true;
            }
        }
    }

    /**
     * This method displays all the information about a certain container from a given id number.
     * @param identificationNumber
     */
    public String displayAllDataFromAnIdNumber(String identificationNumber){
        String whatWeReturn="";
        for(int i=0;i<10;++i) {
            for(int j=0;j<12;++j) {
                if(hub[i][j].getIdNumber().equals(identificationNumber)&&!hub[i][j].isFree()){
                    whatWeReturn+="Is free: "+hub[i][j].isFree()+"\n";
                    whatWeReturn+="Id number: "+hub[i][j].getIdNumber()+"\n";
                    whatWeReturn+="Weight: "+hub[i][j].getWeight()+"\n";
                    whatWeReturn+="Country of origin: "+hub[i][j].getCountryOfOrigin()+"\n";
                    whatWeReturn+="Has been inspected? "+hub[i][j].getHasBeenInspected()+"\n";
                    whatWeReturn+="Priority: "+hub[i][j].getPriorityLevel()+"\n";
                    whatWeReturn+="Description: "+hub[i][j].getContentDescription()+"\n";
                    whatWeReturn+="Company sending the container: "+hub[i][j].getCompanyThatSendsTheContainer()+"\n";
                    whatWeReturn+="Company receiving the container: "+hub[i][j].getCompanyThatReceivesTheContainer()+"\n";
                    whatWeReturn+="Position: ("+(i+1)+","+(j+1)+")\n";
                    return whatWeReturn;
                }
            }
        }
        return "No container was found with that identification number.";
    }

    /**
     * This method tells you how many containers of a given country we have.
     * @param country
     * @return number of containers of a given country
     */
    public int numberOfContainersFromACertainCountry(String country) {
        int counter=0;
        for(int i=0;i<10;++i) {
            for(int j=0;j<12;j++) {
                if(hub[i][j].getCountryOfOrigin().equals(country))
                    counter++;
            }
        }
        return counter;
    }


    public String markAsChecked(String weight,Container[][] hubArgument){//due to some implementation problems, we pass the entire hub as an argument
        String stringToReturn = new String();
                for(int i=0;i<hubArgument.length;i++){
                    for(int k=0;k<hubArgument[i].length;k++){
                        if(Double.parseDouble(hubArgument[i][k].getWeight())<=Double.parseDouble(weight)){
                            hub[i][k].setHasBeenInspected(true);//it's the same as checking the checkbox

                            stringToReturn+="("+i+","+k+")"+"\n"+
                                    hub[i][k].getIdNumber()+"\n"+
                            hub[i][k].getCompanyThatSendsTheContainer()+"\n"+
                            hub[i][k].getWeight()+"\n"+
                            hub[i][k].getHasBeenInspected()+"\n";
                        }
                    }
                }
                return stringToReturn;
    }

    public Container[][] getHub() {
        return hub;
    }

    public void setHub(Container[][] hub) {
        this.hub = hub;
    }

    public boolean isFullPriority1() {
        return isFullPriority1;
    }

    public void setFullPriority1(boolean fullPriority1) {
        isFullPriority1 = fullPriority1;
    }

    public boolean isFullPriority2() {
        return isFullPriority2;
    }

    public void setFullPriority2(boolean fullPriority2) {
        isFullPriority2 = fullPriority2;
    }

    public boolean isFullPriority3() {
        return isFullPriority3;
    }

    public void setFullPriority3(boolean fullPriority3) {
        isFullPriority3 = fullPriority3;
    }
}
