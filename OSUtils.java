public class OSUtils {
    private static String OS = null;
    public String getOsName()
    {
        if(OS == null) { OS = System.getProperty("os.name"); }
        return OS;
    }
    public boolean isWindows()
    {
        return getOsName().startsWith("Windows");
    }

    public boolean isMac(){
        if (getOsName().equalsIgnoreCase("mac os x")){
            return true;
        }else {
            return false;
        }
    }
}
