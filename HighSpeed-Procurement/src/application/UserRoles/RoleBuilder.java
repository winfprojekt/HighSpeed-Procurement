package application.UserRoles;

public class RoleBuilder {

    Long id;
    String name;

    public RoleBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public RoleBuilder withName(String name){
        this.name = name;
        return this;
    }

    public Role build(){
       return  new Role(id, name);
    }

    public static RoleBuilder getBuilder(){
        return new RoleBuilder();
    }
}