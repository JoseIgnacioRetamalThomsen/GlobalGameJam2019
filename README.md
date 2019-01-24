# Global Game Jam 2019

Pre-requisites:
*    Git, Java and Maven working
*    Slick 2D depends on javaws.jar which ships with the Oracle JDK (It's not available in the public Maven repositories). The pom.xml file references a local filesystem path to javaws.jar for that reason.
*    It won't work with OpenJDK for the reason above (Can be solved by providing javaws.jar separately). On some Linux distributions you can install Netx and change the system path to point to netx.jar. For example on Ubuntu the package to install is icedtea-netx-common and the jar is in /usr/share/icedtea-web/netx.jar.

As mentioned above it is required that you have maven installed and can use it from the terminal.

*    If you are using IntelliJ IDEA go to `File > Settings > Build,Execuation,Deployment > Build Tools > Maven > Importing` and click "Import Maven projects automatically"
*    If you are using Eclipse you will have to figure out how to import Maven projects I am unfamiliar with the process.
*    Run `Game`
*    This will fail with `java.lang.UnsatifsiedLinkError`
*    Run `mvn package` once(From your terminal), the native libraries will get copied in `target/natives`
*    Finally edit your VM arguments to inclide `-Djava.library.path=target/natives` In IntelliJ IDEA this can be achieved by editing the run configuration and modifing the `VM Options` field.
