ProGuard
========
ProGuard is a free Java class file shrinker, optimizer, obfuscator, and 
preverifier. It detects and removes unused classes, fields, methods, and 
attributes. It optimizes bytecode and removes unused instructions. It renames 
the remaining classes, fields, and methods using short meaningless names. 
Finally, it preverifies the processed code for Java 6 or for Java Micro Edition.

ProGuard is useful for making code more compact and more efficient, on the 
desktop, on tablets, on smartphones, and on embedded devices. It also makes code
more difficult to reverse engineer.

This is a fork of ProGuard, You can find upstream here: 
  http://sourceforge.net/p/proguard/

# Contributing

We're not adding any features into ProGuard (yet), so pull requests should be
focused on making ProGuard itself faster while still having identical output.

## Building

    ant -f buildscripts/build.xml proguard
Then, you can use `lib/proguard.jar` as a drop in replacement for the
`proguard.jar` shipped with the Android SDK or used by your build tool.

## Contributor License Agreement ("CLA")
In order to accept your pull request, we need you to submit a CLA. You only need to do this once, so if you've done this for another Facebook open source project, you're good to go. If you are submitting a pull request for the first time, just let us know that you have completed the CLA and we can cross-check with your GitHub username.

Complete your CLA here: <https://code.facebook.com/cla>

License
========
GPLv2
