# Installing Amazon Corretto JDK 21 on Ubuntu

This guide provides step-by-step instructions for installing Amazon Corretto JDK 21 on Ubuntu.

## Prerequisites

- Ubuntu operating system (18.04, 20.04, 22.04, or newer)
- sudo privileges

## Installation Steps

### 1. Update Package Index

First, update your package index:

```bash
sudo apt-get update
```

### 2. Install Required Dependencies

Install necessary dependencies:

```bash
sudo apt-get install -y wget apt-transport-https gnupg
```

### 3. Import Amazon Corretto Public Key

Import the Amazon Corretto public key:

```bash
wget -O- https://apt.corretto.aws/corretto.key | sudo apt-key add -
```

### 4. Add Amazon Corretto Repository

Add the Amazon Corretto repository to your system:

```bash
sudo add-apt-repository 'deb https://apt.corretto.aws stable main'
```

### 5. Update Package Index Again

Update your package index to include the new repository:

```bash
sudo apt-get update
```

### 6. Install Amazon Corretto JDK 21

Install Amazon Corretto JDK 21:

```bash
sudo apt-get install -y java-21-amazon-corretto-jdk
```

### 7. Verify Installation

Verify that Amazon Corretto JDK 21 has been installed correctly:

```bash
java -version
```

You should see output similar to:

```
openjdk version "21.0.x" 
OpenJDK Runtime Environment Corretto-21.0.x.x.x (build 21.0.x+x-LTS)
OpenJDK 64-Bit Server VM Corretto-21.0.x.x.x (build 21.0.x+x-LTS, mixed mode, sharing)
```

## Setting JAVA_HOME (Optional)

If you need to set JAVA_HOME environment variable:

1. Find the JDK installation path:

```bash
sudo update-alternatives --config java
```

2. Edit your profile file:

```bash
sudo nano /etc/profile.d/jdk.sh
```

3. Add the following lines (adjust the path based on your installation):

```bash
export JAVA_HOME=/usr/lib/jvm/java-21-amazon-corretto
export PATH=$PATH:$JAVA_HOME/bin
```

4. Make the script executable:

```bash
sudo chmod +x /etc/profile.d/jdk.sh
```

5. Load the environment variables:

```bash
source /etc/profile.d/jdk.sh
```

6. Verify JAVA_HOME is set correctly:

```bash
echo $JAVA_HOME
```

## Troubleshooting

If you encounter any issues with the installation:

1. Check if the repository was added correctly:
   ```bash
   grep -r "corretto" /etc/apt/sources.list /etc/apt/sources.list.d/
   ```

2. Ensure the package is available:
   ```bash
   apt-cache search java-21-amazon-corretto
   ```

3. If you have multiple Java versions installed, you can switch between them using:
   ```bash
   sudo update-alternatives --config java
   ```

## Additional Resources

- [Amazon Corretto Official Documentation](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/what-is-corretto-21.html)
- [Amazon Corretto GitHub Repository](https://github.com/corretto/corretto-21)