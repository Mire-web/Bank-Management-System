public class User{
    public String FIRSTNAME;
    public String LASTNAME;
    public String COUNTRY;
    public String PASSWD;
    public int COUNTRY_CODE;

    public User(String first, String last,String country,int code){
        this.FIRSTNAME = first;
        this.LASTNAME = last;
        this.COUNTRY = country;
        this.COUNTRY_CODE = code;
    }

    public String getFirstName(){
        return FIRSTNAME;
    }
    public void setFirstName(String first){
        this.FIRSTNAME = first;
    }
    public String getLastName(){
        return LASTNAME;
    }
    public void setLastName(String last){
        this.LASTNAME = last;
    }
    public String getCountry(){
        return COUNTRY;
    }
    public void setPasswd(String pass){
        this.PASSWD = pass;
    }
    public String getPasswd(){
        return PASSWD;
    }
}