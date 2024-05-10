class Solution {
    public String rankTeams(String[] votes) {
        int voters=votes.length;
        int ranks=votes[0].length();

        int[][] votesGrid=new int[26][ranks+1];

        for(int i=0;i<26;i++){
            votesGrid[i][ranks]=i;
        }

        for(int i=0;i<voters;i++){
            for(int j=0;j<ranks;j++){
                votesGrid[votes[i].charAt(j)-'A'][j]++; 
            }
        }

        //Sort the grid descending (highest votes first)

        Arrays.sort(votesGrid, (arr1,arr2)->{
            for(int i=0;i<ranks;i++){
                if(arr1[i]!=arr2[i]) return arr2[i]-arr1[i];
            }
            return 0;
        });

        //Get the last column and return as a string

        StringBuilder res=new StringBuilder();
        for(int i=0;i<ranks;i++){
            res.append((char)(votesGrid[i][ranks]+'A'));
        }

        return res.toString();
    }
}
