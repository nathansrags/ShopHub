package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EntityGrouping {
    public static void main(String[] args) {
        EntityGrouping eg = new EntityGrouping();
        eg.prepareEntity();
        String s = "  -42";
        char[] ch = s.trim().toCharArray();
        int i = 0;
        int position = 0;
        for(int k =0;k< s.trim().length();k++){
            if(Character.isLetter(ch[k])){
                return;
            }else{
                position++;
            }
        }
        System.out.println(Integer.parseInt(s.trim().substring(0, position)));
    }

    private void prepareEntity() {

        List<RawEntity> rawEntities = Arrays.asList(
                new RawEntity(1, "Company A", 5000, 3.5, 2.5, 10000, 10, "HR", 2000, 1.8, 1.2, 5000, 100, "Manager", 3000, 2.0, 1.5, 6000, 10, "GG", "GP"),
                new RawEntity(1, "Company A", 5000, 3.5, 2.5, 10000, 10, "HR", 2000, 1.8, 1.2, 5000, 200, "Assistant", 2500, 1.7, 1.4, 5000, 10, "GG", "GP"),
                new RawEntity(1, "Company A", 5000, 3.5, 2.5, 10000, 20, "Finance", 3000, 2.1, 1.6, 7000, 300, "Analyst", 3500, 2.3, 1.8, 7500, 10, "GG", "GP"),
                new RawEntity(2, "Company B", 6000, 4.0, 3.0, 12000, 10, "HR", 2500, 2.0, 1.5, 5500, 100, "Manager", 3200, 2.2, 1.7, 6200, 10, "GG", "GP"),
                new RawEntity(2, "Company B", 6000, 4.0, 3.0, 12000, 30, "Tech", 4000, 2.5, 2.0, 8000, 400, "Developer", 5000, 3.0, 2.5, 9000, 10, "GG", "GP")
        );

        // Transform RawEntity into ContractEntity
        /*List<ContractEntity> contractEntities = rawEntities.stream()
                .collect(Collectors.groupingBy(RawEntity::getEntIdd))
                .entrySet().stream()
                .map(entry -> {
                    List<RawEntity> hotelList = entry.getValue();
                    RawEntity first = hotelList.get(0);
                    List<DepartmentEntity> deptList = hotelList.stream()
                            .collect(Collectors.groupingBy(RawEntity::getDepId))
                            .entrySet().stream()
                            .map(depEntry -> {
                                List<RawEntity> depList = depEntry.getValue();
                                RawEntity deptFirst = depList.get(0);
                                List<PositionEntity> posList = depList.stream()
                                        .map(re -> new PositionEntity(re.getPosId(), re.getPosName(), re.getPoswages(),
                                                re.getPosaverage(), re.getPosrate(), re.getPostotal()))
                                        .collect(Collectors.toList());
                                return new DepartmentEntity(deptFirst.getDepId(), deptFirst.getDeptName(),
                                        deptFirst.getDepwages(), deptFirst.getDepaverage(), deptFirst.getDeprate(), deptFirst.getDeptotal(), posList);
                            }).collect(Collectors.toList());
                    return new ContractEntity(first.getEntIdd(), first.getEntName(), first.getHowages(), first.getHoaverage(),
                            first.getHorate(), first.getHototal(), deptList);
                }).collect(Collectors.toList());
        // Print transformed structure
        contractEntities.forEach(contract -> {
            System.out.println("Contract: " + contract.entName + " (ID: " + contract.entId + ")");
            contract.deptList.forEach(dept -> {
                System.out.println("  - Department: " + dept.deptName + " (ID: " + dept.deptId + ")");
                dept.posList.forEach(pos -> System.out.println("    * Position: " + pos.posName + " (ID: " + pos.posId + ")"));
            });
        });*/

        List<ContractEntity> contractEntities = rawEntities.stream()
                .collect(Collectors.groupingBy(RawEntity::getEntIdd))
                .entrySet().stream()
                .map(entry -> {
                    List<RawEntity> hotelList = entry.getValue();
                    RawEntity first = hotelList.get(0);
                    List<DepartmentEntity> deptList = hotelList.stream()
                            .collect(Collectors.groupingBy(RawEntity::getDepId))
                            .entrySet().stream()
                            .map(depEntry -> {
                                List<RawEntity> depList = depEntry.getValue();
                                RawEntity deptFirst = depList.get(0);
                                List<PositionEntity> posList = depList.stream()
                                        .map(re -> new PositionEntity(re.getPosId(), re.getPosName(), re.getPoswages(),
                                                re.getPosaverage(), re.getPosrate(), re.getPostotal()))
                                        .collect(Collectors.toList());
                                return new DepartmentEntity(deptFirst.getDepId(), deptFirst.getDeptName(),
                                        deptFirst.getDepwages(), deptFirst.getDepaverage(), deptFirst.getDeprate(), deptFirst.getDeptotal(), posList);
                            }).collect(Collectors.toList());
                    return new ContractEntity(first.getEntIdd(), first.getEntName(), first.getHowages(), first.getHoaverage(),
                            first.getHorate(), first.getHototal(), deptList);
                }).collect(Collectors.toList());
        // Print transformed structure
        contractEntities.forEach(contract -> {
            System.out.println("Contract: " + contract.entName + " (ID: " + contract.entId + ")");
            contract.deptList.forEach(dept -> {
                System.out.println("  - Department: " + dept.deptName + " (ID: " + dept.deptId + ")");
                dept.posList.forEach(pos -> System.out.println("    * Position: " + pos.posName + " (ID: " + pos.posId + ")"));
            });
        });



    }

    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    class RawEntity {
        long entIdd;
        String entName;
        double howages;
        double hoaverage;
        double horate;
        double hototal;
        long depId;
        String deptName;
        double depwages;
        double depaverage;
        double deprate;
        double deptotal;
        long posId;
        String posName;
        double poswages;
        double posaverage;
        double posrate;
        double postotal;
        long geid;
        String firstName;
        String lastName;


    }

    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    class ContractEntity {
        long entId;
        String entName;
        double wages;
        double average;
        double rate;
        double total;
        List<DepartmentEntity> deptList;

    }

    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    class DepartmentEntity {
        long deptId;
        String deptName;
        double wages;
        double average;
        double rate;
        double total;
        List<PositionEntity> posList;
    }

    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    class PositionEntity {
        long posId;
        String posName;
        double wages;
        double average;
        double rate;
        double total;
        //List<EmployeeEntity> empList;
    }

    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    class EmployeeEntity {
        long geid;
        String firstName;
        String lastName;
    }
}
