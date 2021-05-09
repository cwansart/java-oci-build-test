# Build a Jakarta EE application with different containerization tools

This is an example to show different ways to build a Jakarta EE application with different containerization tools.

## Dockerfile

Dockerfile is probably one of the most common ways to build containers is a simple Dockerfile. Just run:

```
docker build -t java-oci-build-test:Dockerfile .
docker run -p 9080:9080 java-oci-build-test:Dockerfile
```

## Fabric8's docker-maven-plugin

Then there's Fabric8's (RedHat) docker-maven-module. A similar approach is done by Spotify's dockerfile-maven, which is
has not been updated since 2019.

To use fabric8 you have to add some configuration to your pom.xml (see the project's one in the profiles). With that
approach you can simply include it into your Maven lifecycle and run:

```
mvn package -Pfabric8
docker run -p 8080:8080 java-oci-build-test:fabric8
```

## Buildpack, Paketo

Paketo is an implemenation of CNCF's Buildpack. You can find the documentation how it works an how to install here: https://paketo.io/docs/
Paketo's Maven documentation can be found here: https://github.com/paketo-buildpacks/maven

To build the app with Paketo install Paketo first, then run:
```
pack build java-oci-build-test:paketo --env "BP_MAVEN_BUILD_ARGUMENTS=-Ppaketo package"
```

After that you can run the application with:
```
docker run -p 9080:9080 java-oci-build-test:paketo
```

## jib

For easy Java container creation you can use _jib_. It can be run via CLI or can be included in Maven and Gradle.
See: https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin

Run:
```
mvn package -Pjib
docker run -p 8080:8080 java-oci-build-test:jib
```
