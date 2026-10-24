# 环境搭建记录（Day 1）

> 记录时间：2026-10-23 ~ 10-24
> 目的：换电脑 / 重装系统 / 换网络时，照这份文档 20 分钟能恢复全部环境。

## 1. 已安装的东西

| 组件 | 版本 | 安装位置 | 备注 |
|---|---|---|---|
| JDK | Temurin OpenJDK **21.0.12 LTS** | `E:\Javawenjian\JDK21` | `java -version` 正常，64-Bit Server VM |
| Git | **2.55.0.windows.2** | 默认位置 | 装 Git for Windows 时自带 Git Credential Manager |
| IDEA | **2024.3.7.1** | 默认位置 | 上课装的，Community / Ultimate 未确认 |
| 加速器 | Watt Toolkit（旧名 Steam++）v3.1.0 | 默认位置 | 访问 github.com 必需 |

## 2. 环境变量

```
JAVA_HOME = E:\Javawenjian\JDK21
Path     += %JAVA_HOME%\bin
```

验证三连：

```powershell
java -version
javac -version
echo $env:JAVA_HOME
```

> 注意：改完环境变量必须**关闭所有 PowerShell 窗口重开**，旧窗口不会刷新。

## 3. Git 全局配置

```powershell
git config --global user.name "Fulingxiang"
git config --global user.email "347031794+Fulingxiang@users.noreply.github.com"
git config --global init.defaultBranch main
git config --global http.sslBackend schannel
```

说明：

- `user.email` 用的是 GitHub 的 **noreply 匿名地址**，避免真实邮箱出现在公开提交记录里。
- `http.sslBackend schannel` 是**关键配置**，见下面第 5 节。

## 4. 目录约定

```
E:\Javawenjian\    软件（JDK）
E:\code\           代码项目
E:\code\hello-java 第一个项目
E:\deepseek work\  学习文档（路线图、周计划）
```

规则：**路径不能有中文，尽量不要有空格**。软件和代码分开放。

## 5. 踩过的坑（重要，别再踩）

### 坑 1：JDK 安装时没勾 JAVA_HOME

MSI 安装向导的 "Custom Setup" 里，这两项默认是 **✗（不安装）**，必须手动改成 "Will be installed on local hard drive"：

- `Set JAVA_HOME variable`
- `Add to PATH`

### 坑 2：装到了盘符根目录

第一次把安装位置写成了 `E:\`，会导致 `java.exe` 散落在 `E:\bin`。正确做法是指定完整子目录 `E:\dev\jdk21` 之类。

### 坑 3：git push 报 SSL 证书错误

```
fatal: unable to access '...': SSL certificate problem:
unable to get local issuer certificate (20)
```

**原因**：Watt Toolkit 在本地做 HTTPS 代理，用自己的根证书解密流量。证书装在 Windows 系统证书库，但 Git 默认用自带的证书库，不认识它。

**解法**：

```powershell
git config --global http.sslBackend schannel
```

让 Git 改用 Windows 系统证书库即可。**不要用 `http.sslVerify=false` 长期绕过**，那等于关闭安全检查。

### 坑 4：GitHub 认证不能用账号密码

GitHub 早已不支持密码认证，两条路：

1. 浏览器 OAuth 授权（装 Git for Windows 时的 Credential Manager 会自动弹）——**本次用的是这条**
2. Personal Access Token（`ghp_...`，scope 勾 `repo`），当密码粘贴

### 坑 5：浏览器翻译插件破坏 GitHub 注册页

注册页的国家/地区下拉框点不开，原因是浏览器自动翻译把 JS 组件弄坏了。关掉翻译（"始终不翻译此站点"）+ 刷新即可。

### 坑 6：IDEA 2024 的 Location 字段是父目录

`New Project` 时，如果 Name 填 `hello-java`、Location 也填到 `...\hello-java`，会生成 `...\hello-java\hello-java` 双层目录。正确做法：Location 只填到父目录（如 `E:\code`）。

### 坑 7：访问 GitHub 需要加速器

直连 `github.com` 超时。解决方案：Watt Toolkit → 网络加速 → 勾选 GitHub / GitHub API / 静态资源 → 一键加速。

**push 之前必须确认加速器在运行**，否则会变成网络超时。

## 6. 每天收尾的三条命令

```powershell
cd E:\code\hello-java
git add .
git commit -m "dayN: 一句话描述今天做了什么"
git push
```

提交信息格式建议统一为 `dayN: 描述`，半年后回看一目了然。

## 7. 验收标准

一条 commit 推送成功 + 浏览器能看到 `https://github.com/Fulingxiang/hello-java/src/Main.java`，即环境全部就绪。
