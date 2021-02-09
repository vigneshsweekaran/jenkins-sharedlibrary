@NonCPS
def call(list) {
    for(int i=0; i < list.size(); i++) {
        for (changeLogSet in currentBuild.changeSets) { 
            for (entry in changeLogSet.getItems()) { // for each commit in the detected changes
                for (file in entry.getAffectedFiles()) {
                    print(file.getPath())
                    if (file.getPath() =~ "${list[i]}") {
                        return list[i]
                    }
                }
            }
        }
    }
}
