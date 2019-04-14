package application.UserRoles;


public class Role {
    Long roleId;
    String name;

    public Role(Long roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode(){
        return roleId.intValue();
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Role){
            return getRoleId().equals(((Role) o).getRoleId());
        }
        return false;
    }
}