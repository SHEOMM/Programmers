import java.util.*;
import java.lang.Math;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        ParkingLot parkLot = new ParkingLot(fees[0], fees[1], fees[2], fees[3]);
        List<ParkRecord> parkRecords = new LinkedList<>();
        for(String record: records){
            ParkRecord parkRecord = new ParkRecord(record);
            parkRecords.add(parkRecord);
        }
        parkLot.putRecord(parkRecords);
        int[] answer = new int[parkLot.parkFees.size()];
        String[] sortedKey = new String[parkLot.parkFees.size()];
        int t = 0;
        for(String key: parkLot.parkFees.keySet()){
            sortedKey[t] = key;
            t++;
        }
        Arrays.sort(sortedKey);
        int p = 0;
        for(String key: sortedKey){
            answer[p] = parkLot.parkFees.get(key);
            p++;
        }
        
        
        return answer;
    }
}

class ParkingLot{
    public int basicTime;
    public int basicFee;
    public int unitTime;
    public int unitFee;
    
    public Map<String, Integer> parkFees;
    
    
    public ParkingLot(int basicTime, int basicFee, int unitTime, int unitFee){
        this.basicTime = basicTime;
        this.basicFee = basicFee;
        this.unitTime = unitTime;
        this.unitFee = unitFee;
        parkFees = new HashMap<>();
    }
    
    public void putRecord(List<ParkRecord> records){
        Map<String, List<ParkRecord>> parkRecords = new HashMap<>();
        for(ParkRecord parkRecord: records){
            if(parkRecords.containsKey(parkRecord.carNumber)){
                parkRecords.get(parkRecord.carNumber).add(parkRecord);
            }else{
                List<ParkRecord> list = new LinkedList<>();
                list.add(parkRecord);
                parkRecords.put(parkRecord.carNumber, list);
            }
        }
        calculateFees(parkRecords);
    }
    
    private void calculateFees(Map<String, List<ParkRecord>> parkRecords){
        for(String key: parkRecords.keySet()){
            int totalMins = getTotalMinutes(parkRecords.get(key));
            parkFees.put(key, getTotalFees(totalMins));
        }
    }
    
    private int getTotalMinutes(List<ParkRecord> carRecords){
        int totalMins = 0;
        int start = 0;
        int i = 0;
        for(ParkRecord record: carRecords){
            if(record.type.equals("IN")){
                start = record.time;
                i++;
            }else{
                totalMins += record.time - start;
                start = 0;
                i++;
            }
            
        }
        if(i % 2 != 0){
            totalMins += 23*60 + 59 - start;
        }
        return totalMins;
    }
    
    private int getTotalFees(int minutes){
        int totalFees = basicFee;
        if(minutes > basicTime){
            minutes -= basicTime;
            totalFees += minutes % unitTime == 0 ?
                minutes/unitTime * unitFee : (minutes/unitTime + 1)* unitFee;
        }
        return totalFees;
    }
}

class ParkRecord{
    public int time;
    public String carNumber;
    public String type;
    
    public ParkRecord(String record){
        String[] records = record.split(" ");
        String[] times = records[0].split(":");
        time = 0;
        time += Integer.parseInt(times[0]) * 60;
        time += Integer.parseInt(times[1]);
        carNumber = records[1];
        type = records[2];
    }
    
    @Override
    public String toString(){
        return "" + "time:" + time + " carNumber: " + carNumber + " type: " + type;
    }
    
}