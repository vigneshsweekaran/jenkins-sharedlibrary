def call(list) {
    for(int i=0; i < list.size(); i++) {
        print(i)
        print(currentBuild)
        for (changeLogSet in currentBuild.changeSets) { 
            print(changeLogSet)
            print(changeLogSet.getItems())
            for (entry in changeLogSet.getItems()) { // for each commit in the detected changes
                for (file in entry.getAffectedFiles()) {
                    print(file)
                    print(file.getPath())
                    if (file.getPath() =~ "${list[i]}") {
                        print(list[i])
                        dir (list[i]) {
                            sh 'pwd && ls'
                            sh 'mvn clean package'
                        }
                    }
                }
            }
        }
    }
}
