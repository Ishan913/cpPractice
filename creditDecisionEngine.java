import java.util.*;

public class creditDecisionEngine {

    static class Bureau{
        String fName;
        String lName;
        int anSpend;
        int tAssets;
        int tLiab;
        int hownFlag;
        int bScore;
        int credLimt;

        Bureau(String fName, String lName,int anSpend, int tAssets,int tLiab, int hownFlag,int bScore, int credLimt){
            this.fName=fName;
            this.lName=lName;
            this.anSpend=anSpend;
            this.tAssets=tAssets;
            this.tLiab=tLiab;
            this.hownFlag=hownFlag;
            this.bScore=bScore;
            this.credLimt=credLimt;
        }
    }

    static class Application{
        String id;
        String fName;
        String lName;
        int income;
        Application(String id,String fName, String lName, int income){
            this.id=id;
            this.fName=fName;
            this.lName=lName;
            this.income=income;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int b = s.nextInt();
        List<Bureau> BureauList = new ArrayList<>();
        double avgSpend=0;
        for (int i = 0; i < b; i++) {
            String data = s.next();
            List<String> dList = Arrays.asList(data.split(",",-1));
            Bureau b1 = new Bureau(dList.get(0),dList.get(1),Integer.parseInt(dList.get(2)),Integer.parseInt(dList.get(3)),Integer.parseInt(dList.get(4)),Integer.parseInt(dList.get(5)),Integer.parseInt(dList.get(6)),Integer.parseInt(dList.get(7)));
            BureauList.add(b1);
            avgSpend+=b1.anSpend;
        }
        avgSpend=avgSpend/b;

        int a = s.nextInt();
        List<Application> ApplicationList =new ArrayList<>();
        for (int i = 0; i < a; i++) {
            String data = s.next();
            List<String> dList = Arrays.asList(data.split(",",-1));
            Application a1 = new Application(dList.get(0),dList.get(1),dList.get(2),Integer.parseInt(dList.get(3)));
            ApplicationList.add(a1);
        }

        Collections.sort(ApplicationList, new Comparator<Application>() {
            @Override
            public int compare(Application o1, Application o2) {
                return o1.id.compareTo(o2.id);
            }
        });

        for (int i = 0; i < a; i++) {
            String fName =ApplicationList.get(i).fName;
            String lname = ApplicationList.get(i).lName;
            Optional<Bureau> matchingObject = BureauList.stream().filter(p -> p.fName.equals(fName)&& p.lName.equals(lname)).findFirst();
            Bureau bData = matchingObject.get();

            if ((bData.tAssets>bData.tLiab && ((double)bData.anSpend)/ApplicationList.get(i).income>0.1 && bData.anSpend>avgSpend)){
                if (bData.bScore>50 || (bData.bScore>30 && bData.hownFlag==1)){
                    System.out.println(ApplicationList.get(i).id+",Yes");
                }
            }else
                System.out.println(ApplicationList.get(i).id+",No");


        }

    }



}
