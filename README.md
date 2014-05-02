ProGuard
========

A faster fork of ProGuard.  Based off of ProGuard 4.11.  Our tests show this
fork to be 2.5x faster than upstream ProGuard and produces bit-for-bit identical
output.

You can find upstream here: http://sourceforge.net/p/proguard/code/ci/proguard4.11/tree/

The goal of this fork is to remain bit-for-bit compatible with upstream, and to
ideally get these patches into upstream proguard.

# Contributing

We're not adding any features into ProGuard (yet), so pull requests should be
focused on making ProGuard itself faster while still having identical output.

## Building

    ant -f build/build.xml proguard
Then, you can use `lib/proguard.jar` as a drop in replacement for the
`proguard.jar` shipped with the Android SDK or used by your build tool.

## Contributor License Agreement ("CLA")
In order to accept your pull request, we need you to submit a CLA. You only need to do this once, so if you've done this for another Facebook open source project, you're good to go. If you are submitting a pull request for the first time, just let us know that you have completed the CLA and we can cross-check with your GitHub username.

Complete your CLA here: <https://code.facebook.com/cla>

License
========
GPLv2
