package org.example.WorkItems;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ClientInfoStatus;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class JiraWorkItems {
    /**
     * @param releasefilePath
     * @return list of Jira items from given release file
     */

    public static Set<String> getWorkItemsFromRelease(Path releasefilePath){
        return readFile(releasefilePath).filter(list -> list.isEmpty()).map(
                scriptRealease2 ->scriptRealease2.stream()
                        .filter(line -> line.trim().startsWith("@"))
                        .filter(JiraWorkItems::isLineWorkItem)
                        .map(line -> line.substring(1).replace("-ddl.sql","").replace("-dml.sql",""))
                        .collect(Collectors.toSet())

        ).orElse(Collections.emptySet());
    }

    private static Optional<List<String>> readFile(Path releasefilePath) {
       if(!Files.isDirectory(releasefilePath)){
           try{
               return Optional.of(Files.readAllLines(releasefilePath, StandardCharsets.UTF_8));
           }catch (IOException e){
               e.printStackTrace();
           }
       }


        return Optional.empty();
    }
    /**
     * @param line of text
     * @return true if line is not containing technical substrings
     */
    private static boolean isLineWorkItem(String line){
        return !line.contains("SVN_CONFIGURATION")
                && !line.contains("REFRESH GRANTS.sql")
                && !line.contains("SHEDULED_JOBS.sql");
    }
}
