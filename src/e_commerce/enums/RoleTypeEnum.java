package e_commerce.enums;

public enum RoleTypeEnum {
    OWNER(1),
    CUSTOMER(2);
    public int index;

    RoleTypeEnum(int index) {
        this.index = index;
    }
    public static RoleTypeEnum getRoleTypeByIndex(int index){
        for (RoleTypeEnum roleTypeEnum:RoleTypeEnum.values()) {
            if (roleTypeEnum.index==index){
                return roleTypeEnum;
            }
        }
        return RoleTypeEnum.CUSTOMER;
    }
    public static void GetRoleTypes(){
        for (RoleTypeEnum roleTypeEnum:RoleTypeEnum.values()) {
            System.out.println(roleTypeEnum);
        }
    }
}
