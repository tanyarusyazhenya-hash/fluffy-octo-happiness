# Starfall Client — Fabric 1.21.11 starter

Starter project with a simple ClickGUI screen, keybind (Right Shift), and GitHub Actions build workflow.
Finder toggles are UI placeholders; this project does not implement hidden multiplayer scanning/ESP.

## Build with GitHub
1. Create a repository on GitHub and upload all files from this folder.
2. Open the repository's **Actions** tab.
3. Select **Build Fabric mod** and wait for the workflow to finish.
4. Open the successful run and download **StarfallClient-JAR** under Artifacts.

## Build locally
Requires Java 21 and Gradle. Run `gradle build`; the output is in `build/libs/`.

Minecraft 1.21.11, Fabric Loader, Fabric API, Java 21.
