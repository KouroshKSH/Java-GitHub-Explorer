package com.example.javagithubexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.javagithubexplorer.R;
import com.example.javagithubexplorer.RepoListAdapter;
import com.example.javagithubexplorer.Repository;
import com.example.javagithubexplorer.SpecificRepoActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReposListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos_list);

        // Assuming you have a list of repository data as dummy data
        List<Repository> repositories = new ArrayList<>();
        repositories.add(new Repository("Build your own X", "Stars: 231000", "This repository is a compilation of well-written, step-by-step guides for re-creating our favorite technologies from scratch.", "https://github.com/codecrafters-io/build-your-own-x"));
        repositories.add(new Repository("DiscoFaceGAN", "Stars: 606", "Abstract: We propose DiscoFaceGAN, an approach for face image generation of virtual people with DISentangled, precisely-COntrollable latent representations for identity of non-existing people, expression, pose, and illumination.", "https://github.com/microsoft/DiscoFaceGAN"));
        repositories.add(new Repository("Label Studio", "15000", "Label Studio is an open source data labeling tool. It lets you label data types like audio, text, images, videos, and time series with a simple and straightforward UI and export to various model formats. It can be used to prepare raw data or improve existing training data to get more accurate ML models.", "https://github.com/HumanSignal/label-studio"));
        repositories.add(new Repository("Design Patterns Interview", "60700", "Design patterns are the best, formalized practices a programmer can use to solve common problems when designing an application or system.\\n\\nDesign patterns can speed up the development process by providing tested, proven development paradigms.\\n\\nReusing design patterns help prevent subtle issues that cause major problems, and it also improves code readability for coders and architects who are familiar with the patterns.", "https://github.com/kdn251/interviews"));
        repositories.add(new Repository("GPTs", "12000", "This repo collects leaked prompts of GPTs.", "https://github.com/linexjlin/GPTs"));
        repositories.add(new Repository("Ghidra", "44500", "Ghidra is a software reverse engineering (SRE) framework created and maintained by the National Security Agency Research Directorate. This framework includes a suite of full-featured, high-end software analysis tools that enable users to analyze compiled code on a variety of platforms including Windows, macOS, and Linux. Capabilities include disassembly, assembly, decompilation, graphing, and scripting, along with hundreds of other features. Ghidra supports a wide variety of processor instruction sets and executable formats and can be run in both user-interactive and automated modes. Users may also develop their own Ghidra extension components and/or scripts using Java or Python.", "https://github.com/NationalSecurityAgency/ghidra"));
        repositories.add(new Repository("Swift Programming Language", "64700", "Swift is a high-performance system programming language. It has a clean and modern syntax, offers seamless access to existing C and Objective-C code and frameworks, and is memory-safe by default.\\n\\nAlthough inspired by Objective-C and many other languages, Swift is not itself a C-derived language. As a complete and independent language, Swift packages core features like flow control, data structures, and functions, with high-level constructs like objects, protocols, closures, and generics. Swift embraces modules, eliminating the need for headers and the code duplication they entail.", "https://github.com/apple/swift"));
        //        repositories.add(new Repository("Repository 2", "Stars: 50", "Description of Repository 2"));
        // Add more repository data here as needed

        // Initialize your ListView
        ListView repoListView = findViewById(R.id.repoListView);

        // Create a custom adapter and set it to the ListView
        RepoListAdapter adapter = new RepoListAdapter(this, repositories);
        repoListView.setAdapter(adapter);

//        repoListView.setOnItemClickListener((parent, view, position, id) -> {
//            // Implement redirection logic to SpecificRepoActivity based on the clicked repository
//            Repository selectedRepo = repositories.get(position); // Get the selected repository
//            Intent intent = new Intent(ReposListActivity.this, SpecificRepoActivity.class);
//            intent.putExtra("repository", (Serializable) selectedRepo); // Pass the selected repository object as Serializable
//            startActivity(intent);
//        });

        repoListView.setOnItemClickListener((parent, view, position, id) -> {
            // Implement redirection logic to SpecificRepoActivity based on the clicked repository
            Repository selectedRepo = repositories.get(position); // Get the selected repository
            Intent intent = new Intent(ReposListActivity.this, SpecificRepoActivity.class);
            intent.putExtra("title", selectedRepo.getTitle()); // Pass title
            intent.putExtra("stars", selectedRepo.getStars()); // Pass stars
            intent.putExtra("description", selectedRepo.getDescription()); // Pass description
            intent.putExtra("url", selectedRepo.getUrl()); // Pass description
            startActivity(intent);
        });

//        repoListView.setOnItemClickListener((parent, view, position, id) -> {
//            // Implement redirection logic to SpecificRepoActivity based on the clicked repository
//            Repository selectedRepo = repositories.get(position); // Get the selected repository
//            Intent intent = new Intent(ReposListActivity.this, SpecificRepoActivity.class);
//
//            // Pass the selected repository object as Serializable
//            intent.putExtra("repository", (Serializable) selectedRepo);
//            startActivity(intent);
//        });


    }
}
