public class OSUtils {
  // Cached operating system name to avoid repeated calls to System.getProperty
  private static String OS = null;

  // Method to retrieve  the name of the operating system
  public String getOsName() {
    // If OS name has not been retrieved yet, fetch it from system properties
    if (OS == null) {
      OS = System.getProperty(
          "os.name"); // Get the OS name from system properties
    }
    return OS; // Return the cached OS name
  }

  // Method to check if the operating system is Windows
  public boolean isWindows() {
    // Check if the OS name starts with "Windows"
    return getOsName().startsWith("Windows");
  }

  // Method to check if the operating system is macOS
  public boolean isMac() {
    // Check if the OS name is "mac os x" (case insensitive)
    if (getOsName().equalsIgnoreCase("mac os x")) {
      return true; // Return true if the OS is macOS
    } else {
      return false; // Return false if the OS is not macOS
    }
  }
}
