def user () {
  

  def instance = Jenkins.getInstance()

  // Create a jenkins user

  hudsonRealm.createAccount("jenkinsadmin","password1234")
  instance.setSecurityRealm(hudsonRealm)
}
