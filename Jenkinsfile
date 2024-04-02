pipeline {
    agent any
    tools {
        maven "Maven"
        jdk 'JAVA_HOME'
    }
    
     parameters {
        choice(name: "Pruebas", choices: ["Todos", "Contacts","Login"],description: "Nombre de pruebas definidas para ejecutar")
    }
    
    
    stages {
    
        stage('Ejecutar pruebas') {
                parallel
            {   
            	stage("Run Tests - Todos") 
                {
                    when { expression { params.Pruebas == "Todos" } }
                    steps 
                    {
                        script 
                        {
                            bat "mvn test -DsuiteXmlFiles=suites/testng.xml"
                        }
                        
                    }
                }
                
                stage("Run Tests - Contactos") 
                {
                    when { expression { params.Pruebas == "Contacts" } }
                    steps 
                    {
                        script 
                        {
                          
                           bat "mvn test -DsuiteXmlFiles=suites/SuiteContacts.xml"
                        }
                        
                    }
                }
                
                stage("Run Tests - Login") 
                {
                    when { expression { params.Pruebas == "Login" } }
                    steps 
                    {
                        script 
                        {
                          bat "mvn test -DsuiteXmlFiles=suites/SuiteLogin.xml"
                        }
                        
                    }
                }
                
            }   
        }
    }
    
}