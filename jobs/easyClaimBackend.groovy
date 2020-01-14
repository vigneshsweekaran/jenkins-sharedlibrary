pipelineJob('EasyClaimBackend') {
    
    description('EasyClaimBackend')
    
    definition {
        cpsScm {
            lightweight(true)
            scm{
                git {
                    branch('master')
                    remote{
                        url('https://github.com/vigneshsweekaran/capstone-easyclaim-backend.git')
                        credential('git_credential')
                    }
                    extensions { }
                }
            }
            scriptPath('backend-jenkinsfile')
        }
    }
}
