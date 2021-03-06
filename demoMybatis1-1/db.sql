USE [demoSpring1]
GO
/****** Object:  Table [dbo].[items]    Script Date: 02/06/2021 10:23:19 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[items](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[user_id] [int] NULL,
 CONSTRAINT [PK_items] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 02/06/2021 10:23:19 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[birthday] [date] NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[items] ON 

INSERT [dbo].[items] ([id], [name], [user_id]) VALUES (2, N'hang1', 2)
INSERT [dbo].[items] ([id], [name], [user_id]) VALUES (3, N'hang2', 4)
INSERT [dbo].[items] ([id], [name], [user_id]) VALUES (4, N'hang3', 3)
SET IDENTITY_INSERT [dbo].[items] OFF
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [name], [birthday]) VALUES (2, N'lan', NULL)
INSERT [dbo].[users] ([id], [name], [birthday]) VALUES (3, N'Hoachange', NULL)
INSERT [dbo].[users] ([id], [name], [birthday]) VALUES (4, N'HuyTP', CAST(N'2010-12-01' AS Date))
SET IDENTITY_INSERT [dbo].[users] OFF
ALTER TABLE [dbo].[items]  WITH CHECK ADD  CONSTRAINT [FK_items_users] FOREIGN KEY([id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[items] CHECK CONSTRAINT [FK_items_users]
GO
