import java.util.Arrays;

public class Room_Allotment_Algo{
    int[][] mainGraph = new int[25][26];
    int[][] edges = new int[25][25];
    int [] check=new int[25];
    public int Back(int node , int prev , int B){
        boolean ch=false;
        for (int i=1 ; i<=mainGraph[node][0] ; i++){
            if(mainGraph[node][i]!=prev) {
                int s = Back(mainGraph[node][i], node, B);
                if (s == 1 && prev != -1 && check[mainGraph[node][i]]==0) {
                    edges[mainGraph[node][0]][prev] += 1;
                }
                if (mainGraph[node][i] == B) {
                    ch = true;
                }
            }
        }
        if(ch==true){
            return 1;
        }
        return 0;
    }
    int [] list_touched = new int[25];
    int [] edges_touched = new int[25];
    int cost_in_traversing=0;
    public void BFS_length_of_chain(int current_node , int prev_node , int base_node){
        for (int i=1 ; i<=mainGraph[current_node][0] ; i++){
            if(mainGraph[current_node][i]!=prev_node){
                cost_in_traversing+=edges[mainGraph[current_node][i]][current_node];
                if (mainGraph[current_node][i]==base_node){
                    edges_touched[current_node]=1;
                }
                if(list_touched[mainGraph[current_node][i]]==0 && mainGraph[current_node][i]!=base_node){
                    BFS_length_of_chain(mainGraph[current_node][i] , current_node ,base_node);
                }
            }
        }
    }
    public void BFS_to_calculate_longest_chain(int main_node ){
        Arrays.fill(edges_touched,0);
        for (int i=1 ; i<=mainGraph[main_node][0] ; i++){
            cost_in_traversing=0;
            Arrays.fill(list_touched,0);
            if(edges_touched[mainGraph[main_node][i]]==0) {
                edges_touched[mainGraph[main_node][i]] = 1;
                BFS_length_of_chain(mainGraph[main_node][i],-1,main_node);
            }
        }
    }
    int wing=1,room=0;
    int [][] allotment=new int [5][5];
    int [] alloted_student=new int[25];
    public void room_wing_display(int main_node ){
        alloted_student[main_node]=1;
        allotment[wing][room]=main_node;
        room++;
        if(room>5) {
            room=1;
            wing++;
        }
        for (int i=1 ; i<=mainGraph[main_node][0] ; i++){
            if(alloted_student[mainGraph[main_node][i]]==0){
                room_wing_display(mainGraph[main_node][i]);
            }
        }
    }
    public void Main_Room_Algo() {
        int T=0;
        //cin>>T;
        Arrays.fill(alloted_student,0);
        for (int i = 0; i < T; i++) {
            int a=0,b=0;
            //cin>>a>>b;
            Arrays.fill(check,0);
            Back(a,-1,b);
        }
        int [] nodes=new int[25];
        int redo=1;

        while (redo==1) {
            redo=0;
            int most_probable = 0, val_most_probab = -1;
            for (int i = 0; i < 25; i++) {
                if (val_most_probab == -1 || val_most_probab < mainGraph[i][0]) {
                    most_probable = i;
                    val_most_probab = mainGraph[i][0];
                }
            }
            room_wing_display(most_probable);
            for (int i = 0; i < 25; i++) {
                if (alloted_student[i] == 0) {
                    redo=1;
                }
            }
        }
    }
}