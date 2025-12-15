// Base class provided by the system
public class VersionControl {
  // Simulated "bad" version for testing
  private int badVersion;

  public VersionControl() {
    // default value, or leave uninitialized
  }

  // Constructor to set the first bad version
  public VersionControl(int badVersion) {
    this.badVersion = badVersion;
  }

  // API method: returns true if the given version is bad
  public boolean isBadVersion(int version) {
    return version >= badVersion;
  }
}
