pipelineJob('EasyClaimBackend') {
    
    description('EasyClaimBackend')
    
    triggers {
        scm('* * * * *')
    }
    
    definition {
        cpsScm {
            lightweight(true)
            scm{
                git {
                    branch('master')
                    remote{
                        url('https://github.com/vigneshsweekaran/capstone-easyclaim-backend.git')
                        credentials('git_credential')
                    }
                    extensions { }
                }
            }
            scriptPath('backend-jenkinsfile')
        }
    }
}
