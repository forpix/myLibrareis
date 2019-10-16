def user () {
  

  def instance = Jenkins.getInstance()

  // Create a jenkins user
  def hudsonRealm = new HudsonPrivateSecurityRealm(false)
  hudsonRealm.createAccount("jenkinsadmin","password1234")
  instance.setSecurityRealm(hudsonRealm)
}
