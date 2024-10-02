# Thirsty Plant 2

<img style="display: block; margin-left: auto; margin-right: auto;" src="src/main/resources/icons/good_plant.png">

## Overview

A houseplant care app developed by Owen Graham using Java. The app allows users to enter information about their houseplants, such as name and species, and record when they water them. The app integrates with the [Penenual plant API](https://perenual.com/docs/api) to retrieve data about the species of the user's houseplants so that the app can tell users how soon they need to water them.

> Note: This app is a work in progress

## Contents

<!-- TOC -->
* [Thirsty Plant 2](#thirsty-plant-2)
  * [Overview](#overview)
  * [Contents](#contents)
  * [Technologies Used](#technologies-used)
  * [User Guide](#user-guide)
    * [Prerequisites](#prerequisites)
    * [Setup](#setup)
    * [Running the Application](#running-the-application)
<!-- TOC -->

## Technologies Used



## User Guide

### Prerequisites

- [Maven](https://maven.apache.org/download.cgi)
- [JDK 22](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html)
- [Perenual API key](https://perenual.com/docs/api)

### Setup

_The following instructions are for Windows machines_

1. Clone the git repository: `git clone https://github.com/OwenGraham/Thirsty-Plant-2.git`

Follow these steps to get access to the integrated [Penenual plant API](https://perenual.com/docs/api)

1. Create an account on [perenual.com](https://perenual.com/)
2. Generate an API key by going to the [API documentation page](https://perenual.com/docs/api), clicking `GET API KEY AND ACCESS`, logging in if prompted, and clicking the `Generate New Key` button the page that open.
3. Open a terminal and navigate to the repository root
4. Run the following command to create a properties file containing your API key: `echo api.key=YOUR.API.KEY > src/main/resources/config.properties`

> Make sure to replace "YOUR.API.KEY" with the key you generated on perenual.com

### Running the Application

1. Open a terminal and navigate to the repository root
2. Run the following command to build the project into a Jar file with Maven: `mvn clean package`
3. Start the app by running `java -cp ".\target\classes;target/lib/*" app.App`

